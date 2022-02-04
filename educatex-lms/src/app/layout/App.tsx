import { observer } from "mobx-react-lite";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Forum from "../../features/forum/forum";
import Homepage from "../../features/homepage/homepage";
import HTMLSpace from "../../features/htmlSpace/htmlSpace";
import MySpace from "../../features/mySpace/mySpace";
import Profile from "../../features/profile/profile";
import Quizzes from "../../features/quizzes/quizzes";
import Subjects from "../../features/subjects/subjects";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path='/' element={<Homepage/>}/>
                <Route path='profile' element={<Profile/>}/>
                <Route path='my-space' element={<MySpace/>}/>
                <Route path='subjects' element={<Subjects/>}/>
                <Route path='quizzes' element={<Quizzes/>}/>
                <Route path='forum' element={<Forum/>}/>
                <Route path='html-space' element={<HTMLSpace/>}/>
            </Routes>
        </BrowserRouter>
    );
}

export default observer(App);