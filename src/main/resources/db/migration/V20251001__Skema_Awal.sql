CREATE TABLE guru(
    id VARCHAR(36) NOT NULL,
    nama VARCHAR(255) NOT NULL,
    nip VARCHAR(255),
    PRIMARY KEY(id)
);

CREATE TABLE kelas (
    id VARCHAR(36) NOT NULL,
    id_guru VARCHAR(36) NOT NULL,
    nama VARCHAR(36) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(id_guru) REFERENCES guru(id)
);

CREATE TABLE siswa(
    id VARCHAR(36) NOT NULL,
    id_kelas VARCHAR(36) NOT NULL,
    nama VARCHAR(255) NOT NULL,
    nisn VARCHAR(100) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(id_kelas) REFERENCES kelas(id)
);

CREATE TABLE mapel(
    id VARCHAR(36) NOT NULL,
    nama VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE tahun_akademik (
    id VARCHAR(36) PRIMARY KEY,
    tahun VARCHAR(20) NOT NULL
);

CREATE TABLE semester (
    id VARCHAR(36) PRIMARY KEY,
    nama VARCHAR(20) NOT NULL     -- contoh: Ganjil / Genap atau Semester 1/2
);

-- Relasi guru yang mengajar mapel di kelas tertentu pada tahun ajaran dan semester tertentu
CREATE TABLE kelas_mapel (
    id VARCHAR(36) PRIMARY KEY,
    id_kelas VARCHAR(36) NOT NULL,
    id_mapel VARCHAR(36) NOT NULL,
    id_guru VARCHAR(36) NOT NULL,
    id_tahun_akademik VARCHAR(36) NOT NULL,
    id_semester VARCHAR(36) NOT NULL,
    FOREIGN KEY (id_kelas) REFERENCES kelas(id),
    FOREIGN KEY (id_mapel) REFERENCES mapel(id),
    FOREIGN KEY (id_guru) REFERENCES guru(id),
    FOREIGN KEY (id_tahun_akademik) REFERENCES tahun_akademik(id),
    FOREIGN KEY (id_semester) REFERENCES semester(id)
);

CREATE TABLE nilai(
    id VARCHAR(36) NOT NULL,
    id_siswa VARCHAR(36) NOT NULL,
    id_kelas_mapel VARCHAR(36) NOT NULL,
    nilai_tugas DECIMAL(5,2),
    nilai_ulangan DECIMAL(5,2),
    nilai_uas DECIMAL(5,2),
    total_nilai DECIMAL(5,2),
    deskripsi TEXT,
    PRIMARY KEY(id),
    FOREIGN KEY(id_siswa) REFERENCES siswa(id),
    FOREIGN KEY(id_kelas_mapel) REFERENCES kelas_mapel(id)
);