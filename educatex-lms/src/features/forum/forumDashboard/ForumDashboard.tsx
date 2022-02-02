import React from 'react';
import { Grid } from "semantic-ui-react";
import { useStore } from "../../../app/stores/store";
import { observer } from "mobx-react-lite";
import { IForum } from '../../../app/models/forum';
import ForumList from './ForumList';
import ForumForm from './ForumForm';

export default observer(function ForumDashboard(){
    const {forumStore}= useStore();
    const {selectedForum, editMode}=forumStore;

    return (
        <Grid>
                    <ForumList />
                   {selectedForum && !editMode && (
                    <ForumForm />
                   )}
                    
                    {editMode && (
                       <ForumForm />
                    )}
        </Grid>
    );
})