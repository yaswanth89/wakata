(ns wakata.http
  (:require [ring.adapter.jetty :as jetty]
            [compojure.core :refer :all]
            [wakata.controller :as controller]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.util.response :refer [response]]))

(defroutes handler
  (GET "/schedules" req (controller/schedules req)))

(def app
  (wrap-json-response (response handler) ))

(defn start-server [port]
  (jetty/run-jetty app {:port port}))