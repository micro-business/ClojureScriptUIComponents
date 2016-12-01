(ns micro-business.state)

(def applicationGlobalState
  {:navigationBars [{:id 'topNavigationBar1
                     :brand "Brand 1"
                     :rightToLeftAlignment false
                     :navigationItems [{:id 'item1-1 :caption "Item1-1" :onClickedQueryExpression `[('item1-1/clicked)]}
                                       {:id 'item1-2 :caption "Item1-2" :onClickedQueryExpression `[('item1-2/clicked)]}
                                       {:id 'item1-3 :caption "Item1-3" :href "#item1-3"}
                                       {:id 'item1-4 :caption "Item1-4" :href "#item1-4"}
                                       {:id 'item1-5 :caption "Item1-5" :onClickedQueryExpression `[('item1-5/clicked)]}
                                       {:id 'item1-6 :caption "Item1-6" :href "#item1-6"}
                                       {:id 'item1-7 :caption "Item1-7" :href "#item1-7"}]}

                    {:id 'topNavigationBar2
                     :brand "Brand 2"
                     :rightToLeftAlignment false
                     :navigationItems [{:id 'item2-1 :caption "Item2-1" :onClickedQueryExpression `[('item2-1/clicked)]}
                                       {:id 'item2-2 :caption "Item2-2" :onClickedQueryExpression `[('item2-2/clicked)]}
                                       {:id 'item2-3 :caption "Item2-3" :href "#item2-3"}
                                       {:id 'item2-4 :caption "Item2-4" :href "#item2-4"}
                                       {:id 'item2-5 :caption "Item2-5" :onClickedQueryExpression `[('item2-5/clicked)]}
                                       {:id 'item2-6 :caption "Item2-6" :href "#item2-6"}
                                       {:id 'item2-7 :caption "Item2-7" :href "#item2-7"}]}]})
