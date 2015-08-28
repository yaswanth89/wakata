(ns wakata.http
  (:require [ring.adapter.jetty :as jetty]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [wakata.controller :as controller]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.json :refer [wrap-json-params wrap-json-response]]
            [ring.util.response :refer [response resource-response]]))

(defroutes handler
  (GET "/schedules" {params :params} (response (controller/schedules params)))
  (GET "/rooms" [req] (response (controller/rooms req)))
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