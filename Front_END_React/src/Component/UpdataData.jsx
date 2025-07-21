import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import { getDataBYID } from './Services';
import { UpdateById } from './Services';
import { useNavigate } from 'react-router-dom'
function UpdataData() {
    const { id } = useParams();
    const [name, setName] = React.useState('');
    const [phone, setPhone] = React.useState('');
    const navigate = useNavigate();
    useEffect(() => {
        getDataBYID(id).then((res) => {

            setName(res.data.name);
            setPhone(res.data.phone);


        })
            .catch(err => {
                console.log(err);
            })

    }, [id])

    function HandleSubmit(e) {
        e.preventDefault();
        const updata = { name, phone };
        UpdateById(id, updata).then(res => {
            console.log(res.data);
            navigate('/home');


        })
            .catch(err => {
                console.log(err);

            })


    }
    return (
        <div>
            <div>
                <h1>Update Student Data</h1>
                <form onSubmit={HandleSubmit}>
                    <div className="mb-3">
                        <label htmlFor="name" className="form-label">Name</label>
                        <input type="text" className="form-control" id="name" value={name} onChange={(e) => setName(e.target.value)} />
                        <label htmlFor="name" className="form-label">Phone</label>
                        <input type="text" className="form-control" id="phone" value={phone} onChange={(e) => setPhone(e.target.value)} />
                        <button type="submit" className="btn btn-primary mt-3" >Update</button>

                    </div>
                </form>
            </div>
        </div>
    )
}

export default UpdataData
