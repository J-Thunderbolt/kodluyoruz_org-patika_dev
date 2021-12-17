import { useEffect, useState } from 'react'

export default function Form({ contacts, addContact }) {
    const initialForm = { full_name: "", phone_number: "" };
    const [form, setForm] = useState(initialForm);

    useEffect(() => {
        setForm(initialForm);
    }, [contacts])

    const onChangeInput = (e) => {
        setForm({ ...form, [e.target.name]: e.target.value });
    }

    const onSubmit = (e) => {
        e.preventDefault();
        if (form.full_name === "" || form.phone_number === "") {
            return false;
        }
        addContact([...contacts, form]);
    }

    return (
        <form onSubmit={onSubmit}>
            <div><input name="full_name" onChange={onChangeInput} value={form.full_name} /></div>
            <div><input name="phone_number" onChange={onChangeInput} value={form.phone_number} /></div>
            <div className="btn"><button>Add</button></div>
        </form>
    )
}
