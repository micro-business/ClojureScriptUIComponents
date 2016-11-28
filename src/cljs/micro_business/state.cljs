(ns micro-business.state)

(def applicationGlobalState
  {:navigationBar {:brand "Brand"
                   :rightToLeftAlignment false
                   :navigationItems [{:caption "Item1" :onClickedDispatchKey 'item1/clicked}
                                     {:caption "Item2" :onClickedDispatchKey 'item2/clicked}
                                     {:caption "Item3" :href "#item3"}
                                     {:caption "Item4" :href "#item4"}
                                     {:caption "Item5" :onClickedDispatchKey 'item5/clicked}
                                     {:caption "Item6" :href "#item6"}
                                     {:caption "Item7" :href "#item7"}]}})
