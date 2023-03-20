create table usuarios_roles (
    usuario_id integer not null,
    roles_id integer not null,

    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (roles_id) REFERENCES roles(id)
);