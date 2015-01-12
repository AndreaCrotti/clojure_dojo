(ns clojure-dojo.core.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [clojure-dojo.core.roman :refer [calculate to-int]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/to_int" [roman] (-> roman to-int str))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
