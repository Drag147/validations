SELECT
  v.validation_id AS id,
  v.description   AS description,
  v.version       AS version,
  v.commentary    AS commentary,

  v.severity_id   AS severityId,

  m.message_id    AS m_id,
  m.text          AS m_text,
  m.version       AS m_version,
  m.commentary    AS m_commentary

FROM validation_h v
  JOIN message_h m ON v.message_version_id = m.message_version_id
WHERE v.validation_version_id = :id