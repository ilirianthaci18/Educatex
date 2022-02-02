import { createContext, useContext } from "react";
import CourseStore from "./courseStore";
import ForumStore from "./forumStore";

interface Store {
    courseStore: CourseStore;
    forumStore: ForumStore;
}

export const store: Store = {
    courseStore: new CourseStore(),
    forumStore: new ForumStore()
} 

export const StoreContext = createContext(store);

export function useStore() {
    return useContext(StoreContext);
}