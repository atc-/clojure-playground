(ns clojure-playground.test.core
  (:use [clojure-playground.core])
  (:use [clojure-playground.perm.generate])
  (:use [clojure.test]))

(def LARGE_VECT (vec (range 20000)))

(def SMALL_VECT [1 2 3])

(deftest test-swap-small-input
  (is (= [1 3 2] (swap SMALL_VECT 1 2)) "swap must return [1 3 2] when given input SMALL_VECT and told to swap elements 1 and 2")
  (is (= [2 1 3] (swap SMALL_VECT 1 0)) "swap must return [2 1 3] when given input SMALL_VECT and told to swap elements 2 and 0")
  (is (= [2 3 1] (swap (swap SMALL_VECT 0 1) 1 2)) "swap must return [2 3 1] after multiple (nested) calls: swap 0 and 1 then 1 and 2")
  (is (= [3 2 1] (swap (swap (swap SMALL_VECT 0 1) 1 2) 0 1)) "swap must return [3 2 1] after multiple (nested) calls: swap 0 and 1 then 1 and 2 and finally 0 and 1"))

(deftest test-swap-large-input
  (is (= (assoc (assoc LARGE_VECT  0 1) 1 0) (swap LARGE_VECT 1 0)) "swap must return [1 0...19999] for call with LARGE_VECT and told to swap elements 1 and 0")
  (is (= LARGE_VECT (swap LARGE_VECT 0 0)) "swap must return LARGE_VECT for call with LARGE_VECT and told to swap elements 0 and 0"))

; (deftest test-random-permutation
;   (is (= 5 (random-permutation 0 5))))
