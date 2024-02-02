
import { useRef, useState } from "react";
import { savePostApi } from "../Api/Api";


export default function  NewPost(){
    const postFormRef=useRef();
    const[saveMsg,setSaveMsg]=useState('');

   const savePostToDb = (event) => {
      event.preventDefault();

      const title = postFormRef.current.title.value;
      const author = postFormRef.current.author.value;
      const content = postFormRef.current.content.value;

      const values = {title, author, content };
  
      savePostApi(values)
      .then(() => setSaveMsg('Record successfully saved')
   
        )
      .catch(() => setSaveMsg('Record fail to save'));
  };



    return (
        <div className="container">
        <form ref={postFormRef} onSubmit={savePostToDb}>
          <div className="card mx-auto card-post">
          {saveMsg && <div className="alert alert-warning">{saveMsg}</div>}
          <div className="card-body">
          <h5>Add New Post  </h5>
       
          <div className="form-group">
              <label>Title:</label>
              <input type="text" className="form-control col-sm-6" name="title"/>
          </div>
          <div className="form-group">
              <label>Author:</label>
              <input type="text" className="form-control col-sm-6 mb-3" name="author" />
          </div>
          
          <div className="form-group">
              <label>Content:</label>
              <input type="text" className="form-control col-sm-6 mb-3" name="content"/>
          </div>
        <div className="form-group d-flex">
          <div className='me-2'>
              <button type="submit" className="btn btn-success btn-flat" >Save post </button>
          </div>
    
        </div>    
            
          </div>
          </div>
          </form>
        </div>
    )
}