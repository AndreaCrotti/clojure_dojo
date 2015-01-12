(ns clojure-dojo.core.roman)

(def map-symbols
  {:I 1
   :V 5
   :X 10
   :L 50
   :C 100
   :M 1000
   })

(defn symbol-to-int [sym]
  ((keyword sym) map-symbols))

(defn enum [s]
  (map vector (range) s))

(defn- to-int-worker [roman-reverse-seq]
  (let [max-so-far (atom 0)
        total (atom 0)]
    (doseq [s roman-reverse-seq]
      (if (>= (symbol-to-int s) @max-so-far)
        (do
          (reset! max-so-far (symbol-to-int s))
          (reset! total (+ @total (symbol-to-int s))))
        (reset! total (- @total (symbol-to-int s)))
        )
      )
    @total))

(defn to-int [roman-str]
  (to-int-worker (reverse (map str roman-str))))
