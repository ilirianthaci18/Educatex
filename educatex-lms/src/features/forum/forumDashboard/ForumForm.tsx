import React, { useState } from "react";
import { Button, Form, Segment, TableRow} from 'semantic-ui-react';
import { useStore } from "../../../app/stores/store";
import {observer} from "mobx-react-lite";

export default observer(function ForumForm(){
    const{forumStore} = useStore();
    const {selectedForum, cancelselectedForum, createforum, updateforum, loading} = forumStore;

    const initialState = selectedForum ?? {
        id: '',
        name: '',
        forum_description: '',
    };

    const [forum, setForums] = useState(initialState);

    function handleSubmit() {
        forum.id ? updateforum(forum) : createforum(forum);
    }

    function handleInputChange(event: { target: { name: any; value: any; }; }) {
        const { name, value } = event.target;
        setForums({ ...forum, [name]: value });
    }

    return (
        <Segment style={{marginLeft:'14px', marginBottom:'15px'}}>
        <Form onSubmit={handleSubmit} autoComplete='off' style={{width:'830px', backgroundColor:'#e6e6ff', padding:'10px 10px 10px 10px'}}>
        <TableRow style={{display:'flex', flexDirection:'row', width:'100%'}}>
            <Form.Field>
                <label>Name</label>
                <input placeholder='Date of history..'  value={forum.name}   name='date'  onChange={handleInputChange}/>
            </Form.Field>
            <Form.Field>
                    <label>Forum Description</label>
                    <textarea placeholder='Description of history...'  style={{marginRight:'20px',marginLeft:'20px', width:'400px', height:'20px'}}  value={forum.forum_description}  name='descritpion'  onChange={handleInputChange}/>
            </Form.Field>   
            <Button loading={loading} type='submit' variant="primary"  style={{height:'40px', marginTop:'30px'}}>Submit</Button>
            <Button onClick={cancelselectedForum} type="button" style={{height:'40px', marginTop:'30px'}}>Cancel</Button>
        </TableRow>
        </Form>
        </Segment>
    )
})
