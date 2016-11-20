(ns micro-business.uicomponents.uikit.navigationitem
  (:require
   [om.next :as om :refer-macros [defui]]
   [om.dom :as dom]))

(defn- getNavItem [{:keys [caption href]}]
  (let [navItemStyle #js {}]
    (dom/li
     navItemStyle
     (dom/a
      (if-let [hrefValue href]
        #js {:href hrefValue}
        #js {}) caption))))

(defui NavItem
  static om/IQuery
  (query [this]
         '[:caption :href])
  Object
  (render [this]
          (getNavItem {:caption (-> this om/props :caption)
                       :href (-> this om/props :href)})))

(def navItem (om/factory NavItem))
