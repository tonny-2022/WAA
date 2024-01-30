import { useState } from "react";

 
 export default function Posts(){
    /*const arrposts = [
        { id: 1, title: 'The Great Gatsby', author: 'F. Scott Fitzgerald' },
        { id: 2, title: 'To Kill a Mockingbird', author: 'Harper Lee' },
        { id: 3, title: '1984', author: 'George Orwell' },

        ];
           const[newTitle, setNewTitle]=useState('');
        
            const updatePostTitle=(evt)=>{
                arrposts[0]=newTitle;
                setNewTitle(evt.target.values);

                
            }*/

            const [arrPosts, setArrPosts] = useState([
                { id: 1, title: 'The Great Gatsby', author: 'F. Scott Fitzgerald' },
                { id: 2, title: 'To Kill a Mockingbird', author: 'Harper Lee' },
                { id: 3, title: '1984', author: 'George Orwell' },
              ]);
            
              const [newTitle, setNewTitle] = useState('');

              const updatePostTitle = () => {
                const newArrPosts = [...arrPosts];
                newArrPosts[0].title=newTitle;
                setArrPosts(newArrPosts);
               
              };

          return (
       
           <div className="container">
                <div  id="posts_div" className='row'>
                     {  

                     arrPosts.map(
                        row=>(
                        <div className="card col-sm-3 mx-auto card-posts" >
                        <div class="card-body">
                            <p class="card-text">Id:{row.id}</p>
                            <p class="card-text">Title:{row.title}</p>
                            <p class="card-text">Author:{row.author}</p> 
                        </div>
                        </div>
                        )
                       )
                      }
                    <div className="form-group row" style={{margin: '30px'}}>
                    
                         <label for="title" class="ciol-sm-4 form-label">Title</label>
                        <div className="col-sm-4">
                            <input type="text" id="title" className="form-control col-sm-12" name="txtTitle" 
                            value={newTitle} onChange={(evt) => setNewTitle(evt.target.value)}/>
                        </div>

                        <div className='col-sm-4'>
                        <button type="submit" className="btn btn-primary btn-flat" onClick={updatePostTitle}>Update title</button>
                        </div>
                     </div>

                    
                     

                </div>
                </div>  
            )    
       

    

}

