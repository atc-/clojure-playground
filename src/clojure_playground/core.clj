(ns clojure-playground.core
  (:require [clojure-playground.perm.generate :as pg]
            [clojure-playground.shuffle.brute :as sb])
  (:gen-class))

(defn -main
  [a1 a2 a3]
  (do
    (println a1 a2 a3)))
    ;(if (= "shuffle" a1) 
    ;  (sb/shuf (rest a2 a3)))))
