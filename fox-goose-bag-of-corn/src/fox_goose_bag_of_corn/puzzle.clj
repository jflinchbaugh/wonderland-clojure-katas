(ns fox-goose-bag-of-corn.puzzle)

(def start-pos [[[:fox :goose :corn :you] [:boat] []]])

(defn river-crossing-plan []
  [
    [[:fox :goose :corn :you] [:boat] []]
    [[:corn :fox] [:boat :you :goose] []]
    [[:corn :fox] [:boat] [:you :goose]]
    [[:fox :corn] [:boat :you] [:goose]]
    [[:fox :corn :you] [:boat ] [:goose]]
    [[:corn] [:boat :you :fox] [:goose]]
    [[:corn] [:boat] [:goose :you :fox]]
    [[:corn] [:boat :goose :you] [:fox]]
    [[:corn :you :goose] [:boat] [:fox]]
    [[:goose] [:you :corn :boat] [:fox]]
    [[:goose] [:boat] [:you :corn :fox]]
    [[:goose] [:boat :you] [:corn :fox]]
    [[:goose :you] [:boat] [:corn :fox]]
    [[] [:boat :goose :you] [:corn :fox]]
    [[] [:boat] [:goose :you :corn :fox]]
  ]
)

(defn move-east [[west river east] & [carrying]]
  (let
    [
      west-set (set west)
      river-set (set river)
      east-set (set east)
    ]
    (vec
      (map (comp vec #(filter (complement nil?) %))
        (cond
          (contains? west-set :you carrying) [
            (vec (disj west-set :you carrying))
            (conj river :you carrying)
            east
          ]
          (contains? river-set :you carrying) [
            west
            (vec (disj river-set :you carrying))
            (conj east :you carrying)
          ]
          (contains? east-set :you :carrying) [west river east]
          :else [west river east]
        )
      )
    )
  )
)

(move-east
  (->
    start-pos
    last
  )
  :chicken
)
