(ns wakata.http
  (:require [ring.adapter.jetty :as jetty]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [wakata.controller :as controller]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.json :refer [wrap-json-params wrap-json-response]]
            [ring.util.response :refer [response resource-response]]))

(defroutes handler
  (context "/api" []
    (GET "/schedule" {params :params}
      (controller/schedules (clojure.walk/keywordize-keys params)))
    (GET "/rooms" [req]
      (controller/rooms req))
    (POST "/book" {params :params}
      (controller/book (clojure.walk/keywordize-keys params)))
    (POST "/create" {params :params}
      (controller/create (clojure.walk/keywordize-keys params))))

  (GET "/" [] (resource-response "index.html" {:root "public/dist"}))
  (route/resources "/" {:root "public/dist"})
  (route/not-found (resource-response "404.html" {:root "public/dist"})))

(def app
  (-> handler

    wrap-params
    wrap-json-params
    wrap-json-response))

(defn start-server [port]
  (jetty/run-jetty app {:port port}))