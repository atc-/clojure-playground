; You are given a pack of cards containing X unique cards.
; You are given a number Y that is less than X.
;
; A shuffle is defined as the following:
;
;   Cut the pack Y cards from the top forming two portions: the top portion and the bottom portion
;   Put down the bottom card from the top portion and then the bottom card from the bottom portion
;   Continue in this manner alternating cards until one portion is used up
;   The remaining cards go on top
;
; Write a function/method called noOfShuffles that taxes x and y and returns the number of shuffles 
; that are required in order to return the pack of cards to its original order. For any invalid 
; input values, -1 should be returned.
(defn get-top 
  [coll y]
  (take y coll))

(defn get-btm
  [coll y]
  (drop y coll))

(defn shuf 
  "Cut the items at index y and shuffle by taking each bottom (last) item from each portion (top then bottom portion)
  and adding to a return list"
  [coll y]
  (loop
    [pile '() top (get-top coll y) btm (get-btm coll y)]
    (println pile top btm)
    (if (= (count coll) (count pile))
      pile ; shuffled successfully
      (recur (conj pile (last top) (last btm)) (butlast top) (butlast btm))))) ; keep shufflin'!
 
(defn noOfShuffles [x y]
  (if (< y x)
    (do
      (def op (range 1 (+ 1 x))) ; the reference deck
      (println "op is " op)
      (loop
        [pile (shuf op y) cnt 1]
          (println pile cnt)
          (if (not= op pile)
            (recur (shuf pile y) (+ 1 cnt))
            cnt)) ; work done
      )
    -1))
 
(if (and *command-line-args* (= 2 (count *command-line-args*)))
    (do
        ; A "shortcut" to the first command line argument
        (def X (Integer/parseInt (first *command-line-args*)))

        ; A "shortcut" to the second command line argument
        (def Y (Integer/parseInt (last *command-line-args*)))

        (println (noOfShuffles X Y))
    )

    (println "Please provide X and Y")
)
