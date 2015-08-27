(ns wakata.http
  (:require [ring.adapter.jetty :as jetty]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [wakata.controller :as controller]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.util.response :refer [response]]))

(defroutes handler
  (GET "/schedules" [req] (response (controller/schedules req)))
  (GET "/rooms" [req] (response (controller/rooms req))))

(def app
  (wrap-json-response handler ))

(defn start-server [port]
  (jetty/run-jetty app {:port port}))