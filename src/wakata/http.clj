(ns wakata.http
  (:require [ring.adapter.jetty :as jetty]
            [clojure.pprint :refer :all]
            [wakata.controller :as controller]))

(def routes
  (array-map
    #"/schedules/?" controller/schedules
    #"/add_new/?" controller/add-new))

(defn handler [req]
  (case (:uri req)
    "/"
    {:status 200
     :headers {"Content-Type" "text/html"}
     :body "ascii goatC"}))

(defn start-server [port]
  (jetty/run-jetty handler {:port port}))