import { useState } from "react";

export default function List({ contacts }) {
    const [filterText, setFilterText] = useState("");

    const filteredContacts = contacts.filter((item) =>
        Object.keys(item).some((key) =>
            item[key]
                .toString()
                .toLocaleLowerCase()
                .includes(filterText.toLocaleLowerCase())
        )
    );

    return (
        <div>
            <input
                placeholder="Filter contacts"
                value={filterText}
                onChange={(e) => setFilterText(e.target.value)}
            />
            <ul className="list">
                {filteredContacts.map((contact, idx) => (
                    <li key={idx}>
                        <span>{contact.full_name}</span>
                        <span>{contact.phone_number}</span>
                    </li>
                ))}
            </ul>
            <p>Total Contacts: {filteredContacts.length}</p>
        </div>
    );
}
