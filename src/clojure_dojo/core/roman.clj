(ns clojure-dojo.core.roman)

(def map-symbols
  {:I 1
   :V 5
   :X 10
   :L 50
   :C 100
   :M 1000
   })

(defn calculate [string]
  string)


(defn symbol-to-int [sym]
  ((keyword sym) map-symbols))

(defn to-int [roman]
  (reduce + (map (comp symbol-to-int str) roman)))
