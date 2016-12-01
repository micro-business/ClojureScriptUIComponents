(ns micro-business.uicomponents.uikit.navbar.navigationitem
  (:require
   [om.next :as om :refer-macros [defui]]
   [om.dom :as dom]))

(defn- getNavItem [this props {:keys [caption onClickedQueryExpression href]}]
  (let [navItemStyle #js {}]
    (dom/li
     navItemStyle
     (dom/a
      (if-let [onClickedQueryExpressionValue onClickedQueryExpression]
        #js {:onClick
             (fn [e]
               (om/transact! this onClickedQueryExpressionValue))}
        (if-let [hrefValue href]
          #js {:href hrefValue}
          #js {})) caption))))

(defui NavItem
  static om/Ident
  (ident [this {:keys [id]}]
         [:navitem/by-id id])

  static om/IQuery
  (query [this]
         `[:caption :onClickedQueryExpression :href])

  Object
  (render [this]
          (let [{:keys [caption onClickedQueryExpression href] :as props} (om/props this)]
            (getNavItem this props {:caption caption
                                    :onClickedQueryExpression onClickedQueryExpression
                                    :href href}))))

(def navItem (om/factory NavItem))
