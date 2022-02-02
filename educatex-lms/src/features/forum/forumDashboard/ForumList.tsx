import { TableBody, TableCell, TableHead, TableRow } from '@material-ui/core'; 
import React, { SyntheticEvent, useState } from "react";
import { Table} from 'react-bootstrap';
import { Button, ButtonGroup, Segment} from 'semantic-ui-react';
import { useStore } from "../../../app/stores/store";
import { observer } from "mobx-react-lite";

export default observer(function ForumList(){
    const {forumStore} = useStore();
    const {deleteforum , forumByName, loading} = forumStore;
    const [target, setTarget] = useState("''");
 
    function handleDelete(e: SyntheticEvent<HTMLButtonElement>, id: string) {
        setTarget(e.currentTarget.name);
        deleteforum(id);
    }

    return (
      <Segment style={{margin:'14px 14px 10px 13px', width:'980px'}}>
          <Table />
                <TableHead>
                  <TableRow>
                    <TableCell><b>Name</b></TableCell>
                    <TableCell style={{width:'550px'}}><b>forumDescription</b></TableCell>
                    <TableCell></TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                  {
                    forumByName.map((forum) =>(
                        <TableRow key={forum.id}>
                        <TableCell style={{width:'100px', color:'purple'}}><b>{forum.name}</b></TableCell>
                        <TableCell style={{width:'300px'}}>{forum.forum_description}</TableCell>
                        <TableCell>
                        <ButtonGroup variant="text" >
                          <Button onClick={() => forumStore.selectforum(forum.id)}  basic color="purple"><i>edit</i></Button>
                          <Button name={forum.id}
                                      loading={loading && target === forum.id}
                                      onClick={(e) => handleDelete(e, forum.id)} basic  color="black"><i>delete</i></Button>
                        </ButtonGroup>
                        </TableCell>
                      </TableRow>
                    ))
                  }
                </TableBody>
      </Segment>
  )
})