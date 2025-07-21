import React from 'react'
import { useNavigate } from 'react-router-dom';
import { SaveStudent } from './Services';
function InsertData() {

    const [name, setName] = React.useState('');
    const [phone, setPhone] = React.useState('');
    const navigate = useNavigate();
    function HandleSubmit(e) {
        e.preventDefault();
        const sdata = { name, phone };

        // console.log(sdata)
        console.log("Data Save");
        SaveStudent(sdata).then(res => {
            console.log(res.data);
            navigate('/home');
        }).catch(err => {
            console.log(err);
        });
    }
    return (
        <div>
            <h1>Student New Data Save</h1>
            <form onSubmit={HandleSubmit}>
                <div className="mb-3">
                    <label htmlFor="name" className="form-label">Name</label>
                    <input type="text" className="form-control" id="name" value={name} onChange={(e) => setName(e.target.value)} />
                    <label htmlFor="name" className="form-label">Phone</label>
                    <input type="text" className="form-control" id="phone" value={phone} onChange={(e) => setPhone(e.target.value)} />
                    <button type="submit" className="btn btn-primary mt-3" >Save</button>

                </div>
            </form>
        </div>
    )
}

export default InsertData
