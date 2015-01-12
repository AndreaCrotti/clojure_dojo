(ns clojure-dojo.core.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [clojure-dojo.core.roman :refer [calculate symbol-to-int]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/calc" [string] (calculate string))
  (GET "/to_int" [roman] (symbol-to-int roman))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
