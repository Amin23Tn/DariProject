using sakani.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Threading.Tasks;
using System.Web.Mvc;

namespace sakani.Controllers
{
    public class PanierController : Controller
    {
        public Task<HttpResponseMessage> APIResponse { get; private set; }
        public string BaseAddress { get; private set; }
        public object EntityState { get; private set; }


        public ActionResult Index()
        {
            HttpClient Client = new HttpClient();
            Client.BaseAddress = new Uri("http://localhost:8081");
            Client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage response = Client.GetAsync("Reportt/afficherPanier").Result;
            if (response.IsSuccessStatusCode)
            {
                ViewBag.result = response.Content.ReadAsAsync<IEnumerable<Panier>>().Result;
            }
            else
            {
                ViewBag.result = "error";
            }
            return View();
        }
        [HttpGet]
        public ActionResult Create()
        {
            return View("Create");
        }
        [HttpPost]
        public ActionResult Create(Panier pan)
        {
            HttpClient Client = new HttpClient();
            Client.BaseAddress = new Uri("http://localhost:8081");

            Client.PostAsJsonAsync<Panier>("Reportt/ajouterPanier/{prodname}", pan).ContinueWith((postTask) => postTask.Result.EnsureSuccessStatusCode());
            return RedirectToAction("Index");
        }
        public ActionResult Delete(long id)
        {
            HttpClient client = new HttpClient();

            HttpResponseMessage response = client.DeleteAsync("http://localhost:8081/deletePanier/" +id ).Result;
            return RedirectToAction("Index");

        }
        [HttpPost]
        public void SearchAct()
        {
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8081");
                //HTTP GET
                var responseTask = client.GetAsync("/Carts/{id}/");
                responseTask.Wait();

                var result = responseTask.Result;
                if (result.IsSuccessStatusCode)
                {
                    var readTask = result.Content.ReadAsAsync<Panier>();
                    readTask.Wait();

                    app = readTask.Result;
                }
            }
            Console.WriteLine();
        }
        public ActionResult Edit()
        {
            Panier app = null;

            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8081");
                //HTTP GET
                var responseTask = client.GetAsync("/afficherPanier/" + app.IdPanier);
                responseTask.Wait();

                var result = responseTask.Result;
                if (result.IsSuccessStatusCode)
                {
                    var readTask = result.Content.ReadAsAsync<Panier>();
                    readTask.Wait();

                    app = readTask.Result;
                }
            }

            return View(app);
        }


        [HttpPost]
        public ActionResult Edit(Panier app, int id)
        {

            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8081");

                //HTTP POST
                var putTask = client.PutAsJsonAsync<Panier>("/modify-Appointment/" + id, app);
                putTask.Wait();

                var result = putTask.Result;
                if (result.IsSuccessStatusCode)
                {

                    return RedirectToAction("Index");
                }
            }
            return View(app);
        }
        [HttpGet]
        
        public ActionResult Details(Panier ad)
        {
            

            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8081");
                //HTTP GET
                var responseTask = client.GetAsync("/Carts/{id}/" + ad.IdPanier);
                responseTask.Wait();

                var result = responseTask.Result;
                if (result.IsSuccessStatusCode)
                {
                    var readTask = result.Content.ReadAsAsync<Panier>();
                    readTask.Wait();

                    ad = readTask.Result;
                }
            }

            return View(ad);


            
        }
    }

}
