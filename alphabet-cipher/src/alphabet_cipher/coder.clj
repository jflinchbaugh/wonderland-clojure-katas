(ns alphabet-cipher.coder)

(def alphabet (map char (range (int \a) (int \z))))

(def input alphabet)
(def c 2)
(defn rotate [c input]
  (let
    [
      size (count input)
      shift (mod (+ size c) size)
      front (take shift input)
      back (drop shift input)
    ]
    (concat back front)
  )
)

(def table
  (for [x (range 0 26)]
    (rotate x alphabet)
  )
)


(defn row-for-letter [t l]
  (nth t (- (int l) (int \a)))
)

(def col-for-letter row-for-letter)

(col-for-letter (row-for-letter table \c) \a)

(defn code-for [t r c]
  (col-for-letter (row-for-letter t r) c)
)

(code-for table \b \a)

(defn encode [keyword message]
  (map (partial code-fo)))

(defn decode [keyword message]
  "decodeme")

(defn decipher [cipher message]
  "decypherme")

