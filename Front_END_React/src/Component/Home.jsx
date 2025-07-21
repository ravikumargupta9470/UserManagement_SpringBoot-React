
import { useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import { DeleteStudent, getAllStudent } from './Services';

function Home() {

    const [studdata, setStuddata] = useState([]);
    useEffect(() => {
        getAllStudent().then(res => {
            setStuddata(res.data);

        })
            .catch(err => { console.log(err); })

    }, [])
    const navigate = useNavigate();

    function handleDelete(id) {
        DeleteStudent(id).then(res => {
            // Refresh student list
            getAllStudent().then(res => setStuddata(res.data));
        }).catch(err => {
            console.log(err);
        });


    }
    function updatafun(id) {
        navigate(`/updatedata/${id}`)
    }

    return (
        <div>
            <h1>Welcome to the Home Page</h1>
            <button className="btn btn-primary" onClick={() => navigate('/insert')}>Insert New Data</button>
            <table className="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>

                        <th scope="col">Phone</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    {studdata.map((student) => (
                        <tr key={student.id}>
                            <td>{student.id}</td>
                            <td>{student.name}</td>

                            <td>{student.phone}</td>
                            <td>
                                <button className="btn btn-primary" onClick={() => updatafun(student.id)}>Update</button>
                                <button className="btn btn-danger" onClick={() => handleDelete(student.id)}>Delete</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>

        </div>
    )
}

export default Home
