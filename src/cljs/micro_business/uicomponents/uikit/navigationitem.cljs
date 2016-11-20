(ns micro-business.uicomponents.uikit
  (:require
   [om.next :as om :refer-macros [defui]]
   [om.dom :as dom]))

(def getNavItemStyle #js {})

(defn getNavItemLinkStyle [{:keys [href]}]
  (if-let [hrefValue href]
    #js {:href hrefValue}
    #js {}))

(defn getNavItem [{:keys [caption href]}]
  (dom/li
   getNavItemStyle
   (dom/a (getNavItemLinkStyle {:href href}) caption)))

(defui NavItem
  static om/IQuery
  (query [this]
         '[:caption :href])
  Object
  (render [this]
          (getNavItem {:caption (-> this om/props :caption)
                       :href (-> this om/props :href)})))

(def navItem (om/factory NavItem))
