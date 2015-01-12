(ns clojure-dojo.core.handler-test
  (:require [clojure.test :refer :all]
            [clojure-dojo.core.roman :refer :all]))

;; "I + I"

;; (defn postfix [a op b]
;;   (op a b))

;; (postfix 1 + 2)
;; "(+ I IV)"

(deftest test-roman
  (testing "simple conversion roman to int"
    (is (= (to-int "V") 5))
    (is (= (to-int "VI") 6)())))
