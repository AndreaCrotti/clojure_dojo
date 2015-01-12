(ns clojure-dojo.core.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [clojure-dojo.core.roman :refer [eval]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/calc" [string] (eval string))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
