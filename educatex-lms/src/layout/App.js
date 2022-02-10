import { BrowserRouter, Route, Routes } from "react-router-dom";
import Forum from "../features/forum/forum";
import Homepage from "../features/homepage/homepage";
import HTMLSpace from "../features/htmlSpace/htmlSpace";
import MySpace from "../features/mySpace/mySpace";
import Profile from "../features/profile/profile";
import Subjects from "../features/subjects/subjects";
import ELibrary from "../features/elibrary/elibrary";
import Books from "../features/books/books";
import Trainings from "../features/trainings/trainings";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path='/' element={<Homepage/>}/>
                <Route path='profile' element={<Profile/>}/>
                <Route path='my-space' element={<MySpace/>}/>
                <Route path='subjects' element={<Subjects/>}/>
                <Route path='forum' element={<Forum/>}/>
                <Route path='html-space' element={<HTMLSpace/>}/>
                <Route path='elibrary' element={<ELibrary/>}/>
                <Route path='books' element={<Books/>}/>
                <Route path='trainings' element={<Trainings/>}/>
            </Routes>
        </BrowserRouter>
    );
}

export default App;