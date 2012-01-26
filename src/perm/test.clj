; Unit tests for generate.clj
;
;(ns perm (:import perm.generate))
(ns perm
  (:require clojure.test perm.generate))

(is = [1 3 2] (swap [1 2 3] 1 2) "swap must return [1 3 2] when given input [1 2 3] and told to swap elements 1 and 2")
(is = [3 2 1] (swap [1 2 3] 2 0) "swap must return [3 2 1] when given input [1 2 3] and told to swap elements 2 and 0")
