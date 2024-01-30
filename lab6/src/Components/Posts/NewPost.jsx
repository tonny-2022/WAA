import { Formik,Form, Field} from "formik";


export default function  NewUserComponent(){
   

    return (
    <div className="container">
        <h2>Add New Post</h2>
          <div>
           <Formik>
                      <Form >
                        <fieldset className="form-group">
                         <label>Title</label>
                            <Field type="text"  className="form-control" name="title"/>
                        </fieldset>
                        <fieldset className="form-group">
                         <label>Author</label>
                            <Field type="text"  className="form-control" name="author"/>
                        </fieldset>
                        <fieldset className="form-group">
                         <label>Post date</label>
                            <Field type="date" className="form-control" name="postDate" />
                        </fieldset>
                        <div>
                            <button className="btn btn-primary btn-flat" name="btnNewPost" type="submit"  >Add post</button>
                        </div>
                      </Form>
                </Formik>
              
          </div>
        </div>
    )
}