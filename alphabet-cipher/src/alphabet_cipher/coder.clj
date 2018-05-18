(ns alphabet-cipher.coder)

(def alphabet (map char (range (int \a) (inc (int \z)))))

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
  (for [x (range (count alphabet))]
    (rotate x alphabet)
  )
)

(defn row-for-letter [t l]
  (nth t (- (int l) (int \a)))
)

(def col-for-letter row-for-letter)

(col-for-letter (row-for-letter table \c) \b)

(defn code-for [t r c]
  (col-for-letter (row-for-letter t r) c)
)

(defn decode-for [t r m]
  (char (+ (.indexOf (row-for-letter t r) m) (int \a)))
)

(defn encode [keyword message]
  (apply str
    (for [x (range (count message))]
      (code-for
        table
        (nth (cycle keyword) x)
        (nth message x)
      )
    )
  )
)

(defn decode [keyword message]
  (apply str
    (for [x (range (count message))]
      (decode-for
        table
        (nth (cycle keyword) x)
        (nth message x)
      )
    )
  )
)

(decode-for table \i \m)

(defn decipher [cipher message]
  "decypherme")
