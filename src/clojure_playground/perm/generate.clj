; A program to generate random permutations of a given numerical input
(ns perm)

(defn random
  "Generate a number between i to n inclusive"
  [i n]
  (+ i (rand (+ 1 (- n i))))) 

(defn swap
  "For the given vector, swap the values at elements x and y respectively and return"
  [v x y]
  (assoc (assoc v x (get v y)) y (get v x)))

(defn random-permutation
  "Generate a random permutation of numbers based on a set defined by (rand i n)"
  [i N]
  (dotimes
    [n N]
    (let 
      [random-num (random i N) ; get a random number between i and N
       nums (vec (range random-num))] ; all the numbers up to random-num in a vector
      (swap nums name (random i N))
    )))

(defn main []
  ;(random-permutation (Integer/parseInt (first *command-line-args*)) (Integer/parseInt (second *command-line-args*))))
  (do
    (def v (swap [1 2 3] 1 2))
    (println v))) ; should yield [1 3 2]

(main)
