(ns wonderland-number.finder)

(defn all-same? [x y]
  (let
    [
      s1 (set (str x))
      s2 (set (str y))
    ]
    (= s1 s2)
  )
)

(defn wonderland-number []
  (first
    (filter
      (fn [x]
        (and
          (all-same? x (* 2 x))
          (all-same? x (* 2 x))
          (all-same? x (* 4 x))
          (all-same? x (* 5 x))
          (all-same? x (* 6 x))
        )
      )
      (range 100000 1000000)
    )
  )
)
