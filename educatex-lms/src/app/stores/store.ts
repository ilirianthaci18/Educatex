
import { createContext, useContext } from "react";
import CourseStore from "./courseStore";

interface Store {
    forumStore: CourseStore;
}

export const store: Store = {
    forumStore: new CourseStore()
} 

export const StoreContext = createContext(store);

export function useStore() {
    return useContext(StoreContext);
}
