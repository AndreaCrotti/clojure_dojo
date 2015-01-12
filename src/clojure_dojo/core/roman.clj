(ns clojure-dojo.core.roman)

(def tmp-result (ref 0))

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

(defn enum [s]
  (map vector (range) s))

(defn- to-int-worker [roman-reverse-seq]
  (let [max-so-far (atom 0)
        total (atom 0)]
    (doseq [s roman-reverse-seq]
      (if (> (symbol-to-int s) @max-so-far)
        (do
          (reset! max-so-far (symbol-to-int s))
          (reset! total (+ @total (symbol-to-int s)))
          )
        (reset! total (- @total (symbol-to-int s)))
        )
      )
    @total))

(defn to-int [roman-str]
  (to-int-worker (reverse (map str roman-str))))

(defn loop-over-reversed [roman]
  ;FIXME: get rid of this
  (dosync (ref-set tmp-result 0))
  (let [reversed (enum (reverse (map str roman)))]
    (for [[idx val] reversed]
      (let [intval (symbol-to-int val)]
        (dosync
         (if (= idx 0)
           (ref-set tmp-result (+ @tmp-result intval))
           (if (> intval (nth reversed (- idx 1)))
             (ref-set tmp-result (- @tmp-result intval))
             (ref-set tmp-result (+ @tmp-result intval)))))))))
