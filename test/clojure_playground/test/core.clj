(ns clojure-playground.test.core
  (:use [clojure-playground.core])
  (:use [clojure-playground.perm.generate])
  (:use [clojure.test]))

(def LARGE_VECT (vec (range 20000)))

(deftest test-swap1 
  (is (= [1 3 2] (swap [1 2 3] 1 2)) "swap must return [1 3 2] when given input [1 2 3] and told to swap elements 1 and 2"))

(deftest test-swap2 
  (is (= [3 2 1] (swap [1 2 3] 1 0)) "swap must return [3 2 1] when given input [1 2 3] and told to swap elements 2 and 0"))

(deftest test-swap3 
  (is (= (assoc (assoc LARGE_VECT  0 1) 1 0) (swap LARGE_VECT 1 0)) "swap must return [1 0...19999] for call with LARGE_VECT and told to swap elements 1 and 0"))

(deftest test-swap4 
  (is (= LARGE_VECT (swap LARGE_VECT 0 0)) "swap must return LARGE_VECT for call with LARGE_VECT and told to swap elements 0 and 0"))
