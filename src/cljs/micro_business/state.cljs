(ns micro-business.state)

(def applicationGlobalState
  {:navigationBar {:brand "Brand"
                   :rightToLeftAlignment false
                   :navigationItems [{:id "item1" :caption "Item1" :onClickedDispatchKey 'item1/clicked}
                                     {:id "item2" :caption "Item2" :onClickedDispatchKey 'item2/clicked}
                                     {:id "item3" :caption "Item3" :href "#item3"}
                                     {:id "item4" :caption "Item4" :href "#item4"}
                                     {:id "item5" :caption "Item5" :onClickedDispatchKey 'item5/clicked}
                                     {:id "item6" :caption "Item6" :href "#item6"}
                                     {:id "item7" :caption "Item7" :href "#item7"}]}})
