(ns wakata.http
  (:require [ring.adapter.jetty :as jetty]))
(defn handler [req]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "Hello World"})
(defn start-server [port]
  (jetty/run-jetty handler {:port port}))