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
