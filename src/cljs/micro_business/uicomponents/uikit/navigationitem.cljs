(ns micro-business.uicomponents.uikit.navigationitem
  (:require
   [om.next :as om :refer-macros [defui]]
   [om.dom :as dom]))

(defn- getNavItem [this props {:keys [caption onClickedDispatchKey href]}]
  (let [navItemStyle #js {}]
    (dom/li
     navItemStyle
     (dom/a
      (if-let [onClickedDispatchKeyValue onClickedDispatchKey]
        #js {:onClick
             (fn [e]
               (om/transact! this
                             '[(~onClickedDispatchKeyValue)]))}
        (if-let [hrefValue href]
          #js {:href hrefValue}
          #js {})) caption))))

(defui NavItem
  static om/IQuery
  (query [this]
         '[:caption :onClickedDispatchKey :href])

  Object
  (render [this]
          (let [{:keys [caption onClickedDispatchKey href] :as props} (om/props this)]
            (getNavItem this props {:caption caption
                                    :onClickedDispatchKey onClickedDispatchKey
                                    :href href}))))

(def navItem (om/factory NavItem))
