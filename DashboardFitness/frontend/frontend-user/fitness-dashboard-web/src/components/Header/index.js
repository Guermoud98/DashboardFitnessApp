import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faBell } from '@fortawesome/free-solid-svg-icons';
import './index.css';

const Header = () => {
    return (
        <div className="header-container">
            <div className="row py-3 d-flex align-items-center mb-3 shadow">
                <div className="col-6 d-flex">
                    <div className="input-group rounded-pill">
                        <input type="text" className="form-control rounded-pill" placeholder="Search" />
                        <span className="input-group-text border-0 bg-transparent rounded-pill">
                            <FontAwesomeIcon icon={faBell} />
                        </span>
                    </div>
                </div>
                <div className="col-6 d-flex justify-content-end align-items-center gap-3">
                    <div className="rounded-circle overflow-hidden">
                        {/* Your profile photo */}
                        <img src="https://img.freepik.com/free-vector/isolated-young-handsome-man-different-poses-white-background-illustration_632498-859.jpg?w=740&t=st=1694269159~exp=1694269759~hmac=c8c65095b670091331a550b674305943e6a42c710a45b7356ecfe851d77b916b" alt="Profile" className="img-fluid profile" />
                    </div>
                    <div className="ml-2 bell-icon">
                        <FontAwesomeIcon icon={faBell} />
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Header;
