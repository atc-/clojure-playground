; A program to generate random permutations of a given numerical input
(ns clojure-playground.perm.generate)

(defn random
  "Generate a number between i to n inclusive"
  [i n]
  (+ i (rand (+ 1 (- n i))))) 

(defn swap
  "For the given vector, swap the values at elements x and y respectively and return"
  [v x y]
  (assoc (assoc v x (v y)) y (v x)))

(defn random-permutation
  "Generate a random permutation of numbers based on a set defined by (random i n)"
  [i N]
  (dotimes
    [n N]
    (let 
      [random-num (random i N) ; get a random number between i and N
       nums (vec (range random-num)) ; all the numbers up to random-num in a vector
       r-num (random i N)] ; a random number each element
      (swap nums name r-num)
    )))

