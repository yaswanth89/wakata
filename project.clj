(defproject wakata "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [clj-http "1.0.1"]
                 [clj-time "0.9.0"]
                 [compojure "1.4.0"]
                 [ring/ring-json "0.4.0"]
                 [ring "1.4.0"]
                 [org.clojure/java.jdbc "0.4.1"]
                 [mysql/mysql-connector-java "5.1.6"]
                 [honeysql "0.6.1"]]
  :main wakata.core)
